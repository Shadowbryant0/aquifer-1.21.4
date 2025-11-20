package net.shadow.aquifer.components;

import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.shadow.aquifer.Aquifer;

import java.awt.geom.Arc2D;
import java.util.function.UnaryOperator;

public class AquiferDataComponentsType {
    public static final ComponentType<Float> CHARGE_KEY = register("charge_key", builder -> builder.codec(Codec.FLOAT));
    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator){
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(Aquifer.MOD_ID, name),
                builderOperator.apply(ComponentType.builder()).build());
    }

    public static void regiserDataComponentypes(){
        Aquifer.LOGGER.info("Filtering Data Components for" + Aquifer.MOD_ID);
    }
}
