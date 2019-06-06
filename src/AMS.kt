import java.util.Calendar
import java.util.Random

fun main(args: Array<String>) {
	println("Good ${if (args[0].toInt() < 12 ) "morning" else "night"}, Kotlin");
	feedTheFish();
	
}

fun feedTheFish() {
	val day : String = randomDay();
	val food : String = fishFood(day);
	println("Today is $day and the fish eat $food");
	if (shouldChangeWater(day)){
		println("Change the water today");
	}
}

fun randomDay() : String {
	val week : List<String> = listOf ("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
	return week[Random().nextInt(7)];
}

fun fishFood(day : String) : String {
	
	return when (day){
		"Monday" -> "flakes";
		"Tuesday" -> "pellets";
		"Wednesday" -> "redworms";
		"Thursday" -> "granules";
		"Friday" -> "mosquitoes";
		"Saturday" -> "lettuce";
		"Sunday" -> "plankton";
		else -> "fasting";
	}
}

fun swim(time : Int, speed : String = "fast"){
	println("swimming $speed in $time seconds");
}

fun shouldChangeWater(day : String, temperature : Int = 22, dirty : Int = 20) : Boolean {
	val isTooHot : Boolean = temperature > 	30;
	val isDirty : Boolean = dirty > 30;
	val isSunday : Boolean = day == "Sunday";
	return when {
		isTooHot -> true;
		isDirty -> true;
		isSunday -> true;
		else -> false;
	}
}