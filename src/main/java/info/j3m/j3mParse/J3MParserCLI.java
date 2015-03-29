package info.j3m.j3mParse;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class J3MParserCLI {
	
	public static void main(String[] args) {
		 new J3MParserCLI(args).parse();
	}
	
	private static final Logger log = Logger.getLogger(J3MParserCLI.class.getName());
	 private String[] args = null;
	 private Options options = new Options();

	 public J3MParserCLI(String[] args) {
	  this.args = args;

	  options.addOption("h", "help", false, "show help.");
	  options.addOption("head", "J3mHeader", true, "Extract J3M header from <file>");
	  options.addOption("lm", "LightMeter", true, "Extract Light Meter from <file>");
	  options.addOption("phm", "PressureHPAOrMBAR", true, "Extract Pressure HPAOrMBAR from <file>");
	  options.addOption("pa", "PressureAltitude", true, "Extract Pressure Altitude from <file>");
	  options.addOption("gpsb", "GPSBearing", true, "Extract GPS Bearing from <file>");
	  options.addOption("gpsc", "GPSCoords", true, "Extract GPS Coords from <file>");
	  options.addOption("gpsa", "GPSAccuracy", true, "Extract GPS Accuracy from <file>");
	  options.addOption("gpsd", "GPSData", true, "Extract GPS Data from <file>");
	  options.addOption("acc", "Accelerometer", true, "Extract Accelerometer from <file>");
	  options.addOption("pra", "PitchRollAzimuth", true, "Extract Pitch Roll Azimuth from <file>");
	  options.addOption("vwn", "VisibleWifiNetworks", true, "Extract Visible Wifi Networks from <file>");
	  options.addOption("aud", "AppendedUserData", true, "Extract Appended User Data from <file>");
	  options.addOption("btd", "BlueToothDevices", true, "Extract BlueTooth Devices from <file>");
	  options.addOption("ct", "CellTowers", true, "Extract CellTowers from <file>");
	 }

	 public void parse() {
	  CommandLineParser parser = new BasicParser();
	  CommandLine cmd = null;
	  try {
		  cmd = parser.parse(options, args);

		  if (cmd.hasOption("h"))
			  help();

		  if (cmd.hasOption("head")) {
			  String fileParam = cmd.getOptionValue("head");
			  log.log(Level.INFO, "Outputing J3mHeader for file " + fileParam );
			  File j3mFile = new File(fileParam);
			  try {
				J3mParserImpl j3mParser = new J3mParserImpl(j3mFile);
				log.log(Level.INFO, j3mParser.getJ3MHeader().toString());
			  }
			  catch (Exception e) {
				log.log(Level.SEVERE, "Failed to parse file " + fileParam, e );
			  }
		  }else if (cmd.hasOption("lm")) {
			  String fileParam = cmd.getOptionValue("lm");
				  log.log(Level.INFO, "Outputing Light Meter for file " + fileParam);
				  File j3mFile = new File(fileParam);
				  try {
					J3mParserImpl j3mParser = new J3mParserImpl(j3mFile);
					log.log(Level.INFO, j3mParser.getLightMeter().toString());
				  }
				  catch (Exception e) {
					log.log(Level.SEVERE, "Failed to parse file " + fileParam, e );
				  }
		  }else if (cmd.hasOption("phm")) {
			  String fileParam = cmd.getOptionValue("phm");
				  log.log(Level.INFO, "Outputing Pressure HPAOrMBAR for file " + fileParam);
				  File j3mFile = new File(fileParam);
				  try {
					J3mParserImpl j3mParser = new J3mParserImpl(j3mFile);
					log.log(Level.INFO, j3mParser.getPressureHPAOrMBAR().toString());
				  }
				  catch (Exception e) {
					log.log(Level.SEVERE, "Failed to parse file " + fileParam, e );
				  }
		  }else if (cmd.hasOption("pa")) {
			  String fileParam = cmd.getOptionValue("pa");
				  log.log(Level.INFO, "Outputing Pressure Altitude for file " + fileParam);
				  File j3mFile = new File(fileParam);
				  try {
					J3mParserImpl j3mParser = new J3mParserImpl(j3mFile);
					log.log(Level.INFO, j3mParser.getPressureAltitude().toString());
				  }
				  catch (Exception e) {
					log.log(Level.SEVERE, "Failed to parse file " + fileParam, e );
				  }
		   }else if (cmd.hasOption("pa")) {
			  String fileParam = cmd.getOptionValue("pa");
				  log.log(Level.INFO, "Outputing Pressure Altitude for file " + fileParam);
				  File j3mFile = new File(fileParam);
				  try {
					J3mParserImpl j3mParser = new J3mParserImpl(j3mFile);
					log.log(Level.INFO, j3mParser.getPressureAltitude().toString());
				  }
				  catch (Exception e) {
					log.log(Level.SEVERE, "Failed to parse file " + fileParam, e );
				  }
		   }else if (cmd.hasOption("gpsb")) {
				  String fileParam = cmd.getOptionValue("gpsb");
					  log.log(Level.INFO, "Outputing GPS Bearing for file " + fileParam);
					  File j3mFile = new File(fileParam);
					  try {
						J3mParserImpl j3mParser = new J3mParserImpl(j3mFile);
						log.log(Level.INFO, j3mParser.getGPSBearing().toString());
					  }
					  catch (Exception e) {
						log.log(Level.SEVERE, "Failed to parse file " + fileParam, e );
					  }
		   }else if (cmd.hasOption("gpsc")) {
				  String fileParam = cmd.getOptionValue("gpsc");
					  log.log(Level.INFO, "Outputing GPS Coords for file " + fileParam);
					  File j3mFile = new File(fileParam);
					  try {
						J3mParserImpl j3mParser = new J3mParserImpl(j3mFile);
						log.log(Level.INFO, j3mParser.getGPSCoords().toString());
					  }
					  catch (Exception e) {
						log.log(Level.SEVERE, "Failed to parse file " + fileParam, e );
					  }
		   }else if (cmd.hasOption("gpsa")) {
				  String fileParam = cmd.getOptionValue("gpsa");
					  log.log(Level.INFO, "Outputing GPS Accuracy for file " + fileParam);
					  File j3mFile = new File(fileParam);
					  try {
						J3mParserImpl j3mParser = new J3mParserImpl(j3mFile);
						log.log(Level.INFO, j3mParser.getGPSAccuracy().toString());
					  }
					  catch (Exception e) {
						log.log(Level.SEVERE, "Failed to parse file " + fileParam, e );
					  }
		   }else if (cmd.hasOption("gpsd")) {
				  String fileParam = cmd.getOptionValue("gpsd");
					  log.log(Level.INFO, "Outputing GPS Data for file " + fileParam);
					  File j3mFile = new File(fileParam);
					  try {
						J3mParserImpl j3mParser = new J3mParserImpl(j3mFile);
						log.log(Level.INFO, j3mParser.getGPSData().toString());
					  }
					  catch (Exception e) {
						log.log(Level.SEVERE, "Failed to parse file " + fileParam, e );
					  }
		   }else if (cmd.hasOption("acc")) {
				  String fileParam = cmd.getOptionValue("acc");
					  log.log(Level.INFO, "Outputing Accelerometer for file " + fileParam);
					  File j3mFile = new File(fileParam);
					  try {
						J3mParserImpl j3mParser = new J3mParserImpl(j3mFile);
						log.log(Level.INFO, j3mParser.getAccelerometer().toString());
					  }
					  catch (Exception e) {
						log.log(Level.SEVERE, "Failed to parse file " + fileParam, e );
					  }
		   }else if (cmd.hasOption("pra")) {
				  String fileParam = cmd.getOptionValue("pra");
					  log.log(Level.INFO, "Outputing Pitch Roll Azimuth for file " + fileParam);
					  File j3mFile = new File(fileParam);
					  try {
						J3mParserImpl j3mParser = new J3mParserImpl(j3mFile);
						log.log(Level.INFO, j3mParser.getPitchRollAzimuth().toString());
					  }
					  catch (Exception e) {
						log.log(Level.SEVERE, "Failed to parse file " + fileParam, e );
					  }
		   }else if (cmd.hasOption("vwn")) {
				  String fileParam = cmd.getOptionValue("vwn");
					  log.log(Level.INFO, "Outputing Visible Wifi Networks for file " + fileParam);
					  File j3mFile = new File(fileParam);
					  try {
						J3mParserImpl j3mParser = new J3mParserImpl(j3mFile);
						log.log(Level.INFO, j3mParser.getVisibleWifiNetworks().toString());
					  }
					  catch (Exception e) {
						log.log(Level.SEVERE, "Failed to parse file " + fileParam, e );
					  }
		   }else if (cmd.hasOption("aud")) {
				  String fileParam = cmd.getOptionValue("aud");
					  log.log(Level.INFO, "Outputing Appended User Data for file " + fileParam);
					  File j3mFile = new File(fileParam);
					  try {
						J3mParserImpl j3mParser = new J3mParserImpl(j3mFile);
						log.log(Level.INFO, j3mParser.getAppendedUserData().toString());
					  }
					  catch (Exception e) {
						log.log(Level.SEVERE, "Failed to parse file " + fileParam, e );
					  }
		   }else if (cmd.hasOption("btd")) {
				  String fileParam = cmd.getOptionValue("btd");
					  log.log(Level.INFO, "Outputing BlueTooth Devices for file " + fileParam);
					  File j3mFile = new File(fileParam);
					  try {
						J3mParserImpl j3mParser = new J3mParserImpl(j3mFile);
						log.log(Level.INFO, j3mParser.getBlueToothDevices().toString());
					  }
					  catch (Exception e) {
						log.log(Level.SEVERE, "Failed to parse file " + fileParam, e );
					  }
		   }else if (cmd.hasOption("ct")) {
				  String fileParam = cmd.getOptionValue("ct");
					  log.log(Level.INFO, "Outputing Cell Towers for file " + fileParam);
					  File j3mFile = new File(fileParam);
					  try {
						J3mParserImpl j3mParser = new J3mParserImpl(j3mFile);
						log.log(Level.INFO, j3mParser.getCellTowers().toString());
					  }
					  catch (Exception e) {
						log.log(Level.SEVERE, "Failed to parse file " + fileParam, e );
					  }
		    } else {
			   log.log(Level.SEVERE, "Missing input option");
			   help();
		    }

	  } catch (ParseException e) {
	   log.log(Level.SEVERE, "Failed to parse comand line properties", e);
	   help();
	  }
	 }

	 private void help() {
	  HelpFormatter formater = new HelpFormatter();

	  formater.printHelp("J3MParser", options);
	  System.exit(0);
	 }

}
