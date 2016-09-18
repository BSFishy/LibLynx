package liblynx.api.item;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;

public final class FluidUtils {
    public static final ItemStack EMPTY_BUCKET = new ItemStack(Items.BUCKET);

    public static FluidStack copyStackWithSize(FluidStack stack, int size) {
        FluidStack copy = stack.copy();
        copy.amount = size;
        return copy;
    }

    public static FluidStack copy(FluidStack stack) {
        return stack == null ? null : stack.copy();
    }

    @SuppressWarnings("deprecation")
    public static FluidStack getFluidFromStack(ItemStack stack, boolean simulate) {
        if (stack.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)) {
            return stack.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null).drain(Fluid.BUCKET_VOLUME, !simulate);
        } else if (stack.getItem() instanceof IFluidContainerItem) {
            return ((IFluidContainerItem) stack.getItem()).drain(stack, Fluid.BUCKET_VOLUME, !simulate);
        }

        return null;
    }

    public static boolean hasFluidBucket(FluidStack stack) {
        return stack.getFluid() == FluidRegistry.WATER || stack.getFluid() == FluidRegistry.LAVA || FluidRegistry.getBucketFluids().contains(stack.getFluid());
    }
}
