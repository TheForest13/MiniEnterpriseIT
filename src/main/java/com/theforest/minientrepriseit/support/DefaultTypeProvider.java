package com.theforest.minientrepriseit.support;

import com.theforest.minientrepriseit.api.TypeProvider;
import com.theforest.minientrepriseit.type.Position;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import static com.theforest.minientrepriseit.type.Position.*;

@Service
@RequiredArgsConstructor
public class DefaultTypeProvider implements TypeProvider {

    private final Map<String, Position> nameToPosition = new HashMap<>();

    @PostConstruct
    private void init() {
        nameToPosition.put(DEVELOPER.name(), DEVELOPER);
        nameToPosition.put(QA.name(), QA);
        nameToPosition.put(ANALYST.name(), ANALYST);
        nameToPosition.put(MANAGER.name(), MANAGER);
    }


    @Override
    public Map<String, Position> getPositions() {
        return nameToPosition;
    }
}
