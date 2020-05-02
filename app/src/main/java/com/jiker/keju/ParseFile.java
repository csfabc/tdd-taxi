package com.jiker.keju;
class ParseFile {
	public Travel parseLine(String line) {
		if (line != null && !line.isEmpty() && line.contains(",")){
			return getTravel(line);
		} else {
			return null;
		}
	}
	private Travel getTravel(String line){
		Travel travel = new Travel();
		String strMileage = line.split(",")[0];
		String strTime = line.split(",")[1];
		travel.setMileage(strMileage.substring(0, strMileage.length() - 2));
		travel.setTime(strTime.substring(2, strTime.length() - 2));
		return travel;
	}
	public String parseAll(String content) {
		if (isEmptyString(content)){
			return "";
		}
		String[] arr = content.split("\\s+");
		return parseData(arr);
	}
	private boolean isEmptyString(String str){
		if (str == null || str.length() <= 0){
			return true;
		}
		return false;
	}
	private String parseData(String[] arr){
		String result = "";
		for (String line : arr) {
			result += calculate(line) + "\n";
		}
		return result;
	}
	private String calculate(String line){
		Travel travel = parseLine(line);
		if (travel == null){
			return "";
		}
		TaxiPrice taxiPrice = new TaxiPrice();
		return taxiPrice.calculate(travel.getMileage(), travel.getTime());
	}
}
