package io.spandiar.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionUtilityMethods {

	private List<SoccerPlayer> players = new ArrayList<SoccerPlayer>();
	private Map<String, SoccerPlayer> playersMap = new HashMap<>();

	public List<SoccerPlayer> getPlayers() {
		return players;
	}

	public void setPlayers(List<SoccerPlayer> players) {
		this.players = players;
	}

	public Map<String, SoccerPlayer> getPlayersMap() {
		return playersMap;
	}

	public void setPlayersMap(Map<String, SoccerPlayer> playersMap) {
		this.playersMap = playersMap;
	}

	public void listToMapEnhanced(List<SoccerPlayer> players) {
		playersMap = players.stream().collect(Collectors.toMap(SoccerPlayer::getName, Function.identity()));
	}

	public void listToMapTrivial(final List<SoccerPlayer> players) {
		for (SoccerPlayer player : players) {
			playersMap.put(player.getName(), player);
		}
	}

	@Override
	public String toString() {
		return "CollectionUtilityMethods [players=" + players + ", playersMap=" + playersMap + "]";
	}

	public static void main(String args[]) {

		CollectionUtilityMethods understandings = new CollectionUtilityMethods();

		understandings.setPlayers(Arrays.asList(new SoccerPlayer(4, "Midfield", "Fabregas", "Monaco", "Spain"),
				new SoccerPlayer(10, "Midfielder", "Ozil", "Arsenal", "Germany"),
				new SoccerPlayer(1, "Goalkeeper", "Leno", "Arsenal", "Germany"),
				new SoccerPlayer(14, "Striker", "Henry", "Arsenal", "France"),
				new SoccerPlayer(8, "Striker", "Van Persie", "Galatasaray", "Dutch")));
		
//		List<SoccerPlayer> players2 = understandings.getPlayers();
//		players2.add(new SoccerPlayer(8, "Defender", "Bacary Sagna", "Arsenal", "France"));

		// understandings.listToMapTrivial(understandings.getPlayers());
		understandings.listToMapEnhanced(understandings.getPlayers());
		
		Map<String, SoccerPlayer> playerMap = understandings.getPlayersMap();

//		// print the map - using EntrySet looping
//		for (Map.Entry<String, SoccerPlayer> entry : playerMap.entrySet()) {
//
//			System.out.println("Key is: " + entry.getKey() + " Value is: " + entry.getValue().getPosition());
//		}
//		
//		//Set<Entry<String, SoccerPlayer>> entrySet = playerMap.entrySet();
//
//		// iterate through the map using iterator
//
//		Iterator<Entry<String, SoccerPlayer>> iterator = playerMap.entrySet().iterator();
//		while (iterator.hasNext()) {
//			Map.Entry<String, SoccerPlayer> entry = iterator.next();
//			System.out.println("Key is: " + entry.getKey() + " value is " + entry.getValue().getCurrentClub());
//		}

		// iterate using lambdas

		playerMap.forEach((key, player) -> System.out.println(key + " " + player.getSquadNumber() + " " + player.getPosition()));
		
		// Sort Players
		
		System.out.println("Sorting Players");
		Collections.sort(understandings.getPlayers(), new SoccerPlayer().reversed());
		System.out.println(understandings.getPlayers().toString());

	}
}
