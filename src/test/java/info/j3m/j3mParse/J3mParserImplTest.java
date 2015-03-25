package info.j3m.j3mParse;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import info.j3m.j3mParse.J3MParser;
import info.j3m.j3mParse.J3mParserImpl;


public class J3mParserImplTest {
	private J3MParser j3mParser;

	@Before
	public void constructorTest() throws JsonProcessingException, IOException{
		URL url = this.getClass().getResource("/latest_j3m.json");
		File testJ3M = new File(url.getFile());
		this.j3mParser = new J3mParserImpl(testJ3M);
	}
	
	@Test
	public void getHeaderTest() throws JsonProcessingException, IOException{
		JsonNode node =j3mParser.getJ3MHeader();
		assertFalse(node.toString().contains("sensorCapture"));
		
	}
	@Test
	public void getLightMeterTest() throws JsonProcessingException, IOException{
		JsonNode node = j3mParser.getLightMeter();
		assertTrue(node.toString().contains("lightMeterValue"));
		assertTrue(node.isArray());
	}
	
	@Test
	public void getPressureHPAOrMBARTest() throws JsonProcessingException, IOException{
		JsonNode node = j3mParser.getPressureHPAOrMBAR();
		assertTrue(node.toString().contains("pressureHPAOrMBAR"));
		assertTrue(node.isArray());
	}
	
	@Test
	public void getPressureAltitudeTest() {
		JsonNode node = j3mParser.getPressureAltitude();
		assertTrue(node.toString().contains("pressureAltitude"));
	}
	
	@Test
	public void getGPSBearingTest() {
		JsonNode node = j3mParser.getGPSBearing();
		assertTrue(node.toString().contains("gps_bearing"));
	}
	
	@Test
	public void getGPSCoordsTest(){
		JsonNode node = j3mParser.getGPSCoords();
		assertTrue(node.toString().contains("gps_long"));
		assertTrue(node.toString().contains("gps_lat"));
		assertTrue(!node.toString().contains("gps_coords"));
		assertTrue(node.isArray());
	}
	
	@Test
	public void getGPSDataTest(){
		JsonNode node = j3mParser.getGPSData();
		assertTrue(node.toString().contains("gps_long"));
		assertTrue(node.toString().contains("gps_lat"));
		assertTrue(!node.toString().contains("gps_coords"));
		assertTrue(node.toString().contains("gps_accuracy"));
		assertTrue(node.toString().contains("gps_bearing"));
		assertTrue(node.isArray());
	}
	
	@Test
	public void getGPSAccuracyTest() {
		JsonNode node = j3mParser.getGPSAccuracy();
		assertTrue(node.toString().contains("gps_accuracy"));
	}
	
	@Test
	public void getAccelerometerTest() {
		JsonNode node = j3mParser.getAccelerometer();
		assertTrue(node.toString().contains("acc_x"));
		assertTrue(node.toString().contains("acc_y"));
		assertTrue(node.toString().contains("acc_z"));
		assertTrue(!node.toString().contains("gps_accuracy"));
	}
	
	@Test
	public void getPitchRollAzimuthTest() {
		JsonNode node = j3mParser.getPitchRollAzimuth();
		assertTrue(node.toString().contains("pitch"));
		assertTrue(node.toString().contains("roll"));
		assertTrue(node.toString().contains("azimuth"));
		assertTrue(node.toString().contains("pitchCorrected"));
		assertTrue(node.toString().contains("rollCorrected"));
		assertTrue(node.toString().contains("azimuthCorrected"));
		assertTrue(!node.toString().contains("gps_accuracy"));
	}
	
	@Test
	public void getVisibleWifiNetworksTest() {
		JsonNode node = j3mParser.getVisibleWifiNetworks();
		assertTrue(node.toString().contains("visibleWifiNetworks"));
		assertTrue(!node.toString().contains("gps_accuracy"));
	}
	@Test
	public void getBlueToothDevicesTest() {
		JsonNode node = j3mParser.getBlueToothDevices();
		assertTrue(node.toString().contains("bluetoothDeviceAddress"));
		assertTrue(node.toString().contains("bluetoothDeviceName"));
		assertTrue(!node.toString().contains("gps_accuracy"));
	}

	@Test
	public void getCellTowersTest() {
		JsonNode node = j3mParser.getCellTowers();
		assertTrue(node.toString().contains("cellTowerId"));
		assertTrue(node.toString().contains("MCC"));
		assertTrue(node.toString().contains("LAC"));
		assertTrue(!node.toString().contains("gps_accuracy"));
	}

	@Test
	public void getAppendedUserData() throws Exception {
		URL url = this.getClass().getResource("/j3m.json");
		File testJ3M = new File(url.getFile());
		J3mParserImpl impl = new J3mParserImpl(testJ3M);
		
		JsonNode node = impl.getAppendedUserData();
		assertTrue(node.toString().contains("iWitness Free Text Annotations"));
		assertTrue(!node.toString().contains("gps_accuracy"));

	}
}
