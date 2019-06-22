package Aquarium5

data class Fish (var name:String)

fun main(args: Array<String>)
{
	fishExamples();
}

fun fishExamples(){
	val fish = Fish("splashy");
	
	
	//a problem with this. Every time we call this func, a new lambda object is created. 
	myWith (fish.name){ 
		println(capitalize());
	}
}

//inline: A promise that everytime myWith is called, it will actually transform the source code to inLine, the function.
//That is, the compiler will change the code to replace the Lambda with the instructions inside the Lambda --> zero overhead. 
inline fun myWith(name: String, block: String.() -> Unit){
	//block is now an extension function on a string object and we can apply it to a string
	
	name.block();
}