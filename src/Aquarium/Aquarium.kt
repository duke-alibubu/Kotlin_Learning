package Aquarium

import kotlin.math.PI;

open class Aquarium(var length:Int = 100, var width:Int = 20, var height: Int = 40) {
	//The above is a constructor, with default parameters!
	
	//override getter
	open var volume : Int
		get(){
			return width * height * length / 1000 ;
		}
		set(value:Int){
			height = (value * 1000)/(width*length);
		}
	
	open var water = volume * 0.9;
	
	constructor(numberOfFish: Int): this(){
		val water: Int = numberOfFish * 2000 ;
		val tank: Double = water + water * 0.1 ;
		height = (tank/(length*width)).toInt();
	}
}

class TowerTank(): Aquarium(){
	override var water = volume * 0.8;
	
	override var volume: Int
		get() = (width * height * length * PI/ 1000).toInt();
		set(value){
			height = (value * 1000) / (width * length);
		}
}

fun main(args: Array<String>)
{
	val symptoms: MutableList<String> = mutableListOf("pain","white spots");
	
	print(symptoms.sumBy{it.length}) ;
	
	val cures: MutableMap<String,String> = mutableMapOf("HIV" to "no cures", "Cancer" to "Death");
	cures.put("tank scrubber", "con cac");
}

class MyClass
{
	companion object
	{
		const val CONST3 : String = "const inside object";
	}
}