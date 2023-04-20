package com.xalpol12.entity.jsonentity;

import java.util.List;

public record JSONObject(
        String label,
        Vector3 position,
        Vector3 rotation,
        Vector3 scale,
        List<String> views) {
}
