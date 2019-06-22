package Aquarium.Generics

open class WaterSupply (var needsProcessed: Boolean)
{
	
}

class TapWater: WaterSupply(true)
{
	fun addChemicalCleaners(){
		needsProcessed = false;
	}
}

class FishStoreWater : WaterSupply(false)

class LakeWater: WaterSupply(true)
{
	fun filter(){
		needsProcessed = false;
	}
}

//generic class of type WaterSupply
class Aquarium<T: WaterSupply>(val waterSupply: T)
{
	fun addWater(){
		check(!waterSupply.needsProcessed) {"water supply need processed!";}
		println("adding water from $waterSupply");
	}
}           

fun main(args: Array<String>){
	val aquarium : Aquarium<TapWater> = Aquarium(TapWater());    //type inference
	aquarium.waterSupply.addChemicalCleaners();
	
	val aquar4: Aquarium<LakeWater> = Aquarium(LakeWater());
	aquar4.waterSupply.filter();
	aquar4.addWater();
}