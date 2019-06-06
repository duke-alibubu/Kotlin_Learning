package Aquarium

class Fish(volumeNeeded: Int, val friendly:Boolean = true) {
	val size: Int;
	init{
		if(friendly) size = volumeNeeded;
		else size = 2* volumeNeeded;
		
		println("volume = ${volumeNeeded}");
	}
	constructor(): this(9,true){
		println("running secondary constructor");
	}
}