package info.j3m.j3mParse;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;


public class J3mParserImpl implements J3MParser {
	
	private ObjectNode j3mJson;

	public J3mParserImpl(final ObjectNode j3mJson) throws JsonProcessingException, IOException {
		this.j3mJson = j3mJson;
	}

	public J3mParserImpl(final String j3mJson) throws JsonProcessingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		this.j3mJson = (ObjectNode) mapper.readTree(j3mJson);
	}
	
	public J3mParserImpl(final File j3mFile) throws JsonProcessingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		this.j3mJson = (ObjectNode) mapper.readTree(j3mFile);
	}
	
	public JsonNode getJ3M() {
		return j3mJson;
	}

	public JsonNode getJ3MHeader() {
		ObjectNode j3mData = this.j3mJson;
		((ObjectNode)j3mData.path("data")).remove("sensorCapture");
		return j3mData;
	}

	public JsonNode getLightMeter() {
		return getSensorValue("lightMeterValue");
	}

	public JsonNode getPressureHPAOrMBAR() {
		return getSensorValue("pressureHPAOrMBAR");
	}

	public JsonNode getPressureAltitude() {
		return getSensorValue("pressureAltitude");
	}

	public JsonNode getGPSBearing() {
		return getSensorValue("gps_bearing");
	}

	public JsonNode getGPSCoords() {
		ArrayNode gpsArray = getSensorValue("gps_coords");
		Iterator<JsonNode> iter =  gpsArray.elements();
		while (iter.hasNext()) {
			ObjectNode node = (ObjectNode)iter.next();
			node.set("gps_long", node.get("gps_coords").get(0));
			node.set("gps_lat", node.get("gps_coords").get(1));
			node.remove("gps_coords");
		}
		return gpsArray;

	}

	public JsonNode getGPSAccuracy() {
		return getSensorValue("gps_accuracy");
	}

	public JsonNode getGPSData() {
		ArrayNode gpsArray = getSensorValue("gps_coords","gps_accuracy","gps_bearing");
		Iterator<JsonNode> iter =  gpsArray.elements();
		while (iter.hasNext()) {
			ObjectNode node = (ObjectNode)iter.next();
			node.set("gps_long", node.get("gps_coords").get(0));
			node.set("gps_lat", node.get("gps_coords").get(1));
			node.remove("gps_coords");
		}
		return gpsArray;
	}

	public JsonNode getAccelerometer() {
		return getSensorValue("acc_x","acc_y","acc_z");
	}

	public JsonNode getPitchRollAzimuth() {
		return getSensorValue("pitch","roll","azimuth","pitchCorrected","rollCorrected","azimuthCorrected");
	}

	public JsonNode getVisibleWifiNetworks() {
		return getSensorValue("visibleWifiNetworks");
	}

	public JsonNode getAppendedUserData() {
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode results = mapper.createArrayNode();
		for (final JsonNode objNode : this.j3mJson.path("data").path("userAppendedData")) {
			for (final JsonNode form : objNode.path("associatedForms")){
				results.add(form );
			}
		}
		return results;
	}
	
	public JsonNode getBlueToothDevices() {
		return getSensorValue("bluetoothDeviceAddress","bluetoothDeviceName");
	}

	public JsonNode getCellTowers() {
		return getSensorValue("cellTowerId","MCC","LAC");
	}
	
	public ArrayNode getSensorValue(String... sensors){
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode results = mapper.createArrayNode();
		for (final JsonNode objNode : this.j3mJson.path("data").get("sensorCapture")) {
			ObjectNode newNode = null;
			for(String sensor : sensors){
				if (null != objNode.path("sensorPlayback").get(sensor)){
					if (newNode == null){
						newNode = mapper.createObjectNode();
					}
					newNode.set(sensor, objNode.path("sensorPlayback").get(sensor));
				}
			}
			if (newNode != null){
				newNode.set("timestamp", objNode.get("timestamp"));
				results.add(newNode );
			}
	    }
		return results;
	}
	
}
