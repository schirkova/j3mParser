package info.j3m.j3mParse;
import com.fasterxml.jackson.databind.JsonNode;

public interface J3MParser {
	
	/**
	 * Excludes the timestamped sensor data, and returns the cut down 'header' fields
	 * @return JsonNode  
	 */
	public JsonNode getJ3MHeader();
	
	/**
	 * Returns a JSON array of objects containing a timestamp and a lightMeterValue value
	 * @return JsonNode the results array
	 */
	public JsonNode getLightMeter();
	
	/**
	 * Returns a JSON array of objects containing a timestamp and a pressureHPAOrMBAR value
	 * @return JsonNode the results array
	 */
	public JsonNode getPressureHPAOrMBAR();
	
	/**
	 * Returns a JSON array of objects containing a timestamp and a pressureAltitude value
	 * @return JsonNode the results array
	 */
	public JsonNode getPressureAltitude();
	
	/**
	 * Returns a JSON array of objects containing a timestamp and a gps_bearing value
	 * @return JsonNode the results array
	 */
	public JsonNode getGPSBearing();
	
	/**
	 * Returns a JSON array of objects containing a timestamp and a gps_long and gps_lat values
	 * @return JsonNode the results array
	 */
	public JsonNode getGPSCoords();
	
	/**
	 * Returns a JSON array of objects containing a timestamp and a gps_accuracy value
	 * @return JsonNode the results array
	 */
	public JsonNode getGPSAccuracy();
	
	/**
	 * Returns a JSON array of objects containing a timestamp and a gps_long, gps_lat, gps_accuracy, and gps_bearing values
	 * @return JsonNode the results array
	 */
	public JsonNode getGPSData();
	
	/**
	 * Returns a JSON array of objects containing a timestamp and acc_x, acc_y, and acc_z values
	 * @return JsonNode the results array
	 */
	public JsonNode getAccelerometer();
	
	/**
	 * Returns a JSON array of objects containing a timestamp and pitch, roll, azimuth, pitchCorrected, rollCorrected, and azimuthCorrected values
	 * @return JsonNode the results array
	 */
	public JsonNode getPitchRollAzimuth();
	
	/**
	 * Returns a JSON array of objects containing a timestamp and JSON node with WiFi network values
	 * @return JsonNode the results array
	 */
	public JsonNode getVisibleWifiNetworks();
	
	/**
	 * Returns a JSON array of objects stored in userAppendedData.associatedForms elements of the j3m
	 * @return JsonNode the results array
	 */
	public JsonNode getAppendedUserData();
	
	/**
	 * Returns a JSON array of objects containing a timestamp and bluetoothDeviceAddress and bluetoothDeviceName values
	 * @return JsonNode the results array
	 */
	public JsonNode getBlueToothDevices();
	
	/**
	 * Returns a JSON array of objects containing a timestamp and cellTowerId, MCC, and LAC values
	 * @return JsonNode the results array
	 */
	public JsonNode getCellTowers();
}
