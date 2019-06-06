package Aquarium

class Aquarium(var length:Int = 100, var width:Int = 20, var height: Int = 40) {
	//The above is a constructor, with default parameters!
	
	//override getter
	var volume : Int
		get(){
			return width * height * length / 1000 ;
		}
		set(value:Int){
			height = (value * 1000)/(width*length);
		}
	
	
	constructor(numberOfFish: Int): this(){
		val water: Int = numberOfFish * 2000 ;
		val tank: Double = water + water * 0.1 ;
		height = (tank/(length*width)).toInt();
	}
}