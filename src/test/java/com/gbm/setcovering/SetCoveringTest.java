package com.gbm.setcovering;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class SetCoveringTest {

	@Test
	public void testSetCovering() {

		Map<String, Set<String>> stations = new LinkedHashMap<>();
		stations.put("kone", Set.of("id", "nv", "ut"));
		stations.put("ktwo", Set.of("wa", "id", "mt"));
		stations.put("kthree", Set.of("or", "nv", "ca"));
		stations.put("kfour", Set.of("nv", "ut"));
		stations.put("kfive", Set.of("ca", "az"));

		var greedy = new SetCovering();
		var results = greedy.calculateOptimalStations(stations);

		assertEquals(Set.of("ktwo", "kone", "kthree", "kfive"), results);
	}
}
