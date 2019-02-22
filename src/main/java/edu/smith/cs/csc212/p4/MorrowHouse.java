package edu.smith.cs.csc212.p4;
// followed the SpookyMansion code in order to create my own game :)
import java.util.HashMap;
import java.util.Map;

public class MorrowHouse implements GameWorld{
		private Map<String, Place> places = new HashMap<>();
		//starting point of the user
		@Override
		public String getStart() {
			// front door from quad view
			return "frontQuad";
		}
/**
 * this constructor makes our game, with new places and exits
 */
public MorrowHouse() {
	Place frontQuad = insert(
			Place.create("frontQuad","Welcome to Morrow House, you have walked in from the Quad" ));
	frontQuad.addExit(new Exit("parlor", "Go left to the Parlor. Enter if you Dare, no one ever goes in"));
	/**
	 * Secret Exit is only shown when search is typed in console
	 */
	frontQuad.addExit(new SecretExit("LivingRoom", "Go right to the Living Room."));
	frontQuad.addExit(new Exit("upstairs", "Go up the stairs"));
	
	Place parlor = insert(
			Place.create("parlor","You walk in to the Parlor and see empty bed. Did people actually live in the Parlor?? " ));
	parlor.addExit(new Exit("diningHall", "Abanonded Dining Hall, yes please"));
	parlor.addExit(new Exit("frontQuad", "Go back to the main entrance"));

	/**
	 * adds the dining hall to a Night Place, has two descriptions one for night and one for day
	 */
	NightPlaces diningHall = (NightPlaces) insert(
			NightPlaces.makenew("diningHall","Is this a dining hall? Seems empty","Old abanonded, old abanonded dining Hall at your your services" ));
	diningHall.addExit(new Exit("WilsonKitchen", "Huh? How'd I get to another house?"));
	diningHall.addExit(new Exit("parlor", "Go back to the parlor"));
	
	Place WilsonKitchen = insert(
			Place.terminal("WilsonKitchen","You see Bob, cutting food with a butcher knife... RUNNN" ));
	WilsonKitchen.addExit(new Exit("parlor", "Go back to the parlor"));
	
	Place LivingRoom = insert(
			Place.create("LivingRoom","Living Room: Morrowites playing GuitarHero, that's pretty scary"));
	LivingRoom.addExit(new Exit("frontQuad", "Go back to the main entrance"));
	
	Place upstairs = insert(
			Place.create("upstairs", "Walk up to see the horror of the Fourth Floor"));
	upstairs.addExit(new Exit ("hallway","A hallway before the madness"));
	upstairs.addExit(new Exit ("frontQuad", "Go back to the main entrance"));
	
	Place hallway = insert(
			Place.create("hallway", "I guess the hallway will have to be the safest place on the fourth floor"));
	hallway.addExit(new Exit("Nicky","You walk into an extremely blue room"));
	hallway.addExit(new Exit("myRoom","Kiara doesnt seem to be found, oh wait there is something moving"));
	hallway.addExit(new Exit("bathroom","... communal bathroom"));
	hallway.addExit(new Exit("Kenzie","knock knock, open up kenzie"));
	hallway.addExit(new SecretExit("GwenWuemi", "Gwen, Wuemei...hello is anyone home."));
	hallway.addExit(new Exit("frontQuad","I guess you've scared you off, back downstairs you go "));

	Place GwenWuemi = insert(
			Place.create("GwenWuemi", "the door opens and no one is in"));
	GwenWuemi.addExit(new Exit("hallway","lets go back to the hallway"));
			
	Place Kenzie = insert(
			Place.create("Kenzie", "You steped into a dead end, the door is locked and you have no way out."));
	
	Place Nicky = insert(
			Place.create("Nicky", "NO SHOESS!! take your shoes off before entering"));
	Nicky.addExit(new Exit("closet","a really clean closet.. a little too clean. She must be hading something"));
	Nicky.addExit(new Exit("hallway","This OCD is a little much for me, back to the hallway"));

	Place closet = insert(
			Place.create("closet","this is really clean... hmmmm"));
	closet.addExit(new Exit("Nicky","go back to Nicky's room"));
	
	Place myRoom = insert(
			Place.create("myRoom", "ummm is that a body. you check and find her roommate... unconscious possibly?"));
	myRoom.addExit(new Exit("closet2","oh this is a huge closet."));
	myRoom.addExit(new Exit("hallway","lets get to the bottom of this..."));
	
	Place closet2 = insert(
			Place.create("closet2","You move the clothes to the side and see a bunch of bodies"));
	closet2.addExit(new Exit("myRoom","go back to the bedroom"));
	
	Place bathroom = insert(
			Place.create("bathroom", "you hear a bunch of noises coming from the bathroom, so you walk in"));
	bathroom.addExit(new Exit("showers","it's coming from the showers..."));
	bathroom.addExit(new Exit("hallway","This is too much, I think i'll pass on investingating"));
	bathroom.addExit(new Exit ("housekeeping","hide in this closet"));
	
	Place showers = insert(Place.terminal("showers", "ahhh you find a hair monster in the showers! Who knows if you'll make it out alive or be a victim"));
	
	Place housekeeping = insert(Place.terminal("housekeeping", "I think you'll be safe here."));
	checkAllExitsGoSomewhere();
}

private void checkAllExitsGoSomewhere() {
	boolean missing = false;
	// For every place:
	for (Place p : places.values()) {
		// For every exit from that place:
		for (Exit x : p.getVisibleExits()) {
			// That exit goes to somewhere that exists!
			if (!places.containsKey(x.getTarget())) {
				// Don't leave immediately, but check everything all at once.
				missing = true;
				// Print every exit with a missing place:
				System.err.println("Found exit pointing at " + x.getTarget() + " which does not exist as a place.");
			}
		}
	}
	
	// Now that we've checked every exit for every place, crash if we printed any errors.
	if (missing) {
		throw new RuntimeException("You have some exits to nowhere!");
	}
}
private Place insert(Place p) {
	places.put(p.getId(), p);
	return p;
}

public Place getPlace(String id) {
	return this.places.get(id);		
}
}
