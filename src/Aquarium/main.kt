package Aquarium

fun main (args: Array<String>){
	buildAquarium();
}

fun buildAquarium(){
	val myAquarium = Aquarium();
	println(myAquarium.volume);
	
	myAquarium.volume = 100;
	println(myAquarium.height);
	
	val fish = Fish(2);
}