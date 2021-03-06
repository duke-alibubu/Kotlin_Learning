package Aquarium

fun main (args: Array<String>){
	buildAquarium();
}

fun buildAquarium(){
	val myAquarium = Aquarium();
	println(myAquarium.volume);
	
	myAquarium.volume = 100;
	println(myAquarium.height);
	
	makeFish();
	
}

fun makeFish(){
	val shark = Shark();
	val pleco = Plecostomus();
	println("Shark: ${shark.color} \nPlecostomus ${pleco.color}");
	shark.eat();
	pleco.eat();
}

fun feedFish(fish: FishAction){
	//polymorphism
	fish.eat();
}