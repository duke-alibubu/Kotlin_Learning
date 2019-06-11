package Aquarium.Decorations

fun main(args: Array<String>){
	makeDecorations();
}

fun makeDecorations(){
	val d1 = Decorations("granite");
	val d2 = Decorations("slate");
	val d3 = Decorations("slate");
	
	println(d1);
	println(d2);
	println(d3);
	
	//possible to compare data classes
	println(d2.equals(d3));
	
	val d4 : Decorations = d3.copy();
	println(d4);
	
	val d5 = Decorations2("crystal","wood","diver");
	println(d5);
	
	val (rock: String, wood: String, diver: String) = d5;
	println(rock);
	println(wood);
	println(diver);
}

data class Decorations(val rocks: String){}

data class Decorations2(val rocks: String, val wood: String, val diver: String){}
