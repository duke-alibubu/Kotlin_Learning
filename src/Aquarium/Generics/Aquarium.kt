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
class Aquarium<out T: WaterSupply>(val waterSupply: T)
{
	fun addWater(cleaner: Cleaner<T>){
		if (waterSupply.needsProcessed){
			cleaner.clean(waterSupply);
		}
		println("adding water from ${waterSupply}");
	}
	
	inline fun <reified R: WaterSupply> hasWaterSupplyOfType() = waterSupply is R;
}           

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("Out type received");

interface Cleaner<in T: WaterSupply>
{
	fun clean(waterSupply: T);
}

class TapWaterCleaner: Cleaner<TapWater>
{
	override fun clean(waterSupply: TapWater){
		waterSupply.addChemicalCleaners();
	}
}
fun main(args: Array<String>){
	val aquarium : Aquarium<TapWater> = Aquarium(TapWater());    //type inference
	aquarium.waterSupply.addChemicalCleaners();
	
	val aquar4: Aquarium<LakeWater> = Aquarium(LakeWater());
	aquar4.waterSupply.filter();
	val cleaner:TapWaterCleaner = TapWaterCleaner();
	aquarium.addWater(cleaner);
	addItemTo(aquarium);
	
	aquarium.hasWaterSupplyOfType<TapWater>();
}

inline fun <reified R: WaterSupply> Aquarium<*>.hasWhatTypeofWaterSupply() = waterSupply is R;

fun <T: WaterSupply> isWaterClean(aquarium: Aquarium<T>)
{
	println("aquarium water is clean: ${aquarium.waterSupply.needsProcessed}");
}