package net.shadow.aquifer.util;

import net.minecraft.entity.player.PlayerEntity;

import java.util.UUID;

public class UuidCheck {
    private static final UUID UUIDD = UUID.fromString("db004548-e5c5-4be4-a989-48b4b92be61f");

    public static boolean isUUID(PlayerEntity player) {
        return player.getUuid().equals(UUIDD);
    }
}