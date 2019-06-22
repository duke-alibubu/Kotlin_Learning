package Aquarium5

data class Fish (var name:String)

fun main(args: Array<String>)
{
	fishExamples();
}

fun fishExamples(){
	val fish = Fish("splashy");
	
	myWith (fish.name){ 
		println(capitalize());
	}
}

fun myWith(name: String, block: String.() -> Unit){
	//block is now an extension function on a string object and we can apply it to a string
	
	name.block();
}