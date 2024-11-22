package com.gbm.setcovering;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SetCovering {

	public Set<String> calculateOptimalStations(Map<String, Set<String>> stations) {
		var statesNeeded = extractStatesNeeded(stations);
		var finalStations = new HashSet<String>();

		while (!statesNeeded.isEmpty()) {
			var bestStation = findBestStation(stations, statesNeeded);
			if (bestStation != null) {
				finalStations.add(bestStation.getKey());
				statesNeeded.removeAll(bestStation.getValue());
			}
		}
		return finalStations;
	}

	private Map.Entry<String, Set<String>> findBestStation(Map<String, Set<String>> stations,
			Set<String> statesNeeded) {
		var statesCovered = new HashSet<String>();
		Map.Entry<String, Set<String>> bestEntry = null;

		for (var stationEntry : stations.entrySet()) {
			var covered = new HashSet<>(statesNeeded);
			covered.retainAll(stationEntry.getValue());

			if (covered.size() > statesCovered.size()) {
				statesCovered = covered;
				bestEntry = stationEntry;
			}
		}

		return bestEntry;
	}

	private Set<String> extractStatesNeeded(Map<String, Set<String>> stations) {
		return stations.values().stream().flatMap(Set::stream).collect(Collectors.toSet());
	}
}
