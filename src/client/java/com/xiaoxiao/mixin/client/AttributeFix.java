package com.xiaoxiao.mixin.client;

import net.minecraft.entity.attribute.ClampedEntityAttribute;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;


@Mixin(ClampedEntityAttribute.class)
public class AttributeFix {
    @Final
    @Shadow
    private double minValue;


    /**
     * @author xiaoxiao
     * @reason fixAttribute
     */
    @Overwrite
    public double getMaxValue(){
        return Double.MAX_VALUE;
    }

    /**
     * @author xiaoxiao
     * @reason fixAttribute
     */
    @Overwrite
    public double clamp(double value){
        return Double.isNaN(value) ? this.minValue :  Math.max(value, this.minValue);
    }

}