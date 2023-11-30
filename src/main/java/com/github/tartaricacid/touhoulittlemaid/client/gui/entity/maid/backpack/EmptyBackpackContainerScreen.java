package com.github.tartaricacid.touhoulittlemaid.client.gui.entity.maid.backpack;

import com.github.tartaricacid.touhoulittlemaid.TouhouLittleMaid;
import com.github.tartaricacid.touhoulittlemaid.client.gui.entity.maid.AbstractMaidContainerGui;
import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import com.github.tartaricacid.touhoulittlemaid.inventory.container.backpack.EmptyBackpackContainer;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class EmptyBackpackContainerScreen extends AbstractMaidContainerGui<EmptyBackpackContainer> implements IBackpackContainerScreen {
    private static final ResourceLocation BACKPACK = new ResourceLocation(TouhouLittleMaid.MOD_ID, "textures/gui/maid_gui_backpack.png");
    private final EntityMaid maid;

    public EmptyBackpackContainerScreen(EmptyBackpackContainer container, Inventory inv, Component titleIn) {
        super(container, inv, titleIn);
        this.imageHeight = 256;
        this.imageWidth = 256;
        this.maid = menu.getMaid();
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTicks, int x, int y) {
        super.renderBg(graphics, partialTicks, x, y);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, BACKPACK);
        graphics.blit(BACKPACK, leftPos + 85, topPos + 36, 0, 0, 165, 122);
        graphics.fill(leftPos + 142, topPos + 58, leftPos + 250, topPos + 76, 0xaa222222);
        graphics.blit(BACKPACK, leftPos + 190, topPos + 62, 165, 0, 11, 11);
        graphics.fill(leftPos + 142, topPos + 81, leftPos + 250, topPos + 117, 0xaa222222);
        graphics.blit(BACKPACK, leftPos + 190, topPos + 92, 165, 0, 11, 11);
        graphics.fill(leftPos + 142, topPos + 122, leftPos + 250, topPos + 158, 0xaa222222);
        graphics.blit(BACKPACK, leftPos + 190, topPos + 133, 165, 0, 11, 11);
    }
}