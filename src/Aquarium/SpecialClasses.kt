package Aquarium

object MobyDickWhale {
	val author = "Herman Melville";
	fun jump(){
		//...
	}
}

enum class Color(var rgb: Int){
	RED (0xFF000),
	GREEN (0x00FF00),
	BLUE (0x0000FF)
}

sealed class Seal

class SeaLion: Seal();
class Walrus: Seal();
