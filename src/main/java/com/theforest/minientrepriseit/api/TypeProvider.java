package com.theforest.minientrepriseit.api;

import com.theforest.minientrepriseit.type.Position;

import java.util.Map;

public interface TypeProvider {
    Map<String, Position> getPositions();
}
