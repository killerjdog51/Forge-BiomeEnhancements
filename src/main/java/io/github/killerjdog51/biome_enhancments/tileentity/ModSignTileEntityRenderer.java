package io.github.killerjdog51.biome_enhancments.tileentity;

import java.util.List;

import com.mojang.blaze3d.platform.GlStateManager;

import io.github.killerjdog51.biome_enhancments.BiomeEnhancements;
import io.github.killerjdog51.biome_enhancments.blocks.ModStandingSignBlock;
import io.github.killerjdog51.biome_enhancments.blocks.ModWallSignBlock;
import io.github.killerjdog51.biome_enhancments.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.RenderComponentsUtil;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.model.SignModel;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModSignTileEntityRenderer extends TileEntityRenderer<ModSignTileEntity>
{
	 	private static final ResourceLocation OAK_SIGN = new ResourceLocation("textures/entity/signs/oak.png");
	 	private static final ResourceLocation MANGROVE_SIGN = new ResourceLocation(BiomeEnhancements.MOD_ID + ":textures/entity/signs/mangrove.png");
	 	private static final ResourceLocation PALM_SIGN = new ResourceLocation(BiomeEnhancements.MOD_ID + ":textures/entity/signs/palm.png");
	 	private static final ResourceLocation BAOBAB_SIGN = new ResourceLocation(BiomeEnhancements.MOD_ID + ":textures/entity/signs/baobab.png");
	 	
	 	private final SignModel model = new SignModel();

	    public void render(ModSignTileEntity tileEntityIn, double x, double y, double z, float partialTicks, int destroyStage) {
	       BlockState blockstate = tileEntityIn.getBlockState();
	       GlStateManager.pushMatrix();
	       if (blockstate.getBlock() instanceof ModStandingSignBlock) {
	          GlStateManager.translatef((float)x + 0.5F, (float)y + 0.5F, (float)z + 0.5F);
	          GlStateManager.rotatef(-((float)(blockstate.get(ModStandingSignBlock.ROTATION) * 360) / 16.0F), 0.0F, 1.0F, 0.0F);
	          this.model.getSignStick().showModel = true;
	       } else {
	          GlStateManager.translatef((float)x + 0.5F, (float)y + 0.5F, (float)z + 0.5F);
	          GlStateManager.rotatef(-blockstate.get(ModWallSignBlock.FACING).getHorizontalAngle(), 0.0F, 1.0F, 0.0F);
	          GlStateManager.translatef(0.0F, -0.3125F, -0.4375F);
	          this.model.getSignStick().showModel = false;
	       }

	       if (destroyStage >= 0) {
	          this.bindTexture(DESTROY_STAGES[destroyStage]);
	          GlStateManager.matrixMode(5890);
	          GlStateManager.pushMatrix();
	          GlStateManager.scalef(4.0F, 2.0F, 1.0F);
	          GlStateManager.translatef(0.0625F, 0.0625F, 0.0625F);
	          GlStateManager.matrixMode(5888);
	       } else {
	          this.bindTexture(this.textures(blockstate.getBlock()));
	       }

	       GlStateManager.enableRescaleNormal();
	       GlStateManager.pushMatrix();
	       GlStateManager.scalef(0.6666667F, -0.6666667F, -0.6666667F);
	       this.model.renderSign();
	       GlStateManager.popMatrix();
	       FontRenderer fontrenderer = this.getFontRenderer();
	       GlStateManager.translatef(0.0F, 0.33333334F, 0.046666667F);
	       GlStateManager.scalef(0.010416667F, -0.010416667F, 0.010416667F);
	       GlStateManager.normal3f(0.0F, 0.0F, -0.010416667F);
	       GlStateManager.depthMask(false);
	       int i = tileEntityIn.getTextColor().func_218388_g();
	       if (destroyStage < 0) {
	          for(int j = 0; j < 4; ++j) {
	             String s = tileEntityIn.getRenderText(j, (p_212491_1_) -> {
	                List<ITextComponent> list = RenderComponentsUtil.splitText(p_212491_1_, 90, fontrenderer, false, true);
	                return list.isEmpty() ? "" : list.get(0).getFormattedText();
	             });
	             if (s != null) {
	                fontrenderer.drawString(s, (float)(-fontrenderer.getStringWidth(s) / 2), (float)(j * 10 - tileEntityIn.signText.length * 5), i);
	                if (j == tileEntityIn.getLineBeingEdited() && tileEntityIn.func_214065_t() >= 0) {
	                   int k = fontrenderer.getStringWidth(s.substring(0, Math.max(Math.min(tileEntityIn.func_214065_t(), s.length()), 0)));
	                   int l = fontrenderer.getBidiFlag() ? -1 : 1;
	                   int i1 = (k - fontrenderer.getStringWidth(s) / 2) * l;
	                   int j1 = j * 10 - tileEntityIn.signText.length * 5;
	                   if (tileEntityIn.func_214069_r()) {
	                      if (tileEntityIn.func_214065_t() < s.length()) {
	                         AbstractGui.fill(i1, j1 - 1, i1 + 1, j1 + 9, -16777216 | i);
	                      } else {
	                         fontrenderer.drawString("_", (float)i1, (float)j1, i);
	                      }
	                   }

	                   if (tileEntityIn.func_214067_u() != tileEntityIn.func_214065_t()) {
	                      int k1 = Math.min(tileEntityIn.func_214065_t(), tileEntityIn.func_214067_u());
	                      int l1 = Math.max(tileEntityIn.func_214065_t(), tileEntityIn.func_214067_u());
	                      int i2 = (fontrenderer.getStringWidth(s.substring(0, k1)) - fontrenderer.getStringWidth(s) / 2) * l;
	                      int j2 = (fontrenderer.getStringWidth(s.substring(0, l1)) - fontrenderer.getStringWidth(s) / 2) * l;
	                      this.func_217657_a(Math.min(i2, j2), j1, Math.max(i2, j2), j1 + 9);
	                   }
	                }
	             }
	          }
	       }

	       GlStateManager.depthMask(true);
	       GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
	       GlStateManager.popMatrix();
	       if (destroyStage >= 0) {
	          GlStateManager.matrixMode(5890);
	          GlStateManager.popMatrix();
	          GlStateManager.matrixMode(5888);
	       }

	    }

	    private ResourceLocation textures(Block p_217658_1_) {
	       if (p_217658_1_ != ModBlocks.BAOBAB_SIGN && p_217658_1_ != ModBlocks.BAOBAB_WALL_SIGN) {
	          if (p_217658_1_ != ModBlocks.MANGROVE_SIGN && p_217658_1_ != ModBlocks.MANGROVE_WALL_SIGN) {
	                      return p_217658_1_ != ModBlocks.PALM_SIGN && p_217658_1_ != ModBlocks.PALM_WALL_SIGN ? OAK_SIGN : PALM_SIGN;
	                   } else {
	                      return MANGROVE_SIGN;
	                   }
	                } else {
	                   return BAOBAB_SIGN;
	                }
	             } 

	    private void func_217657_a(int p_217657_1_, int p_217657_2_, int p_217657_3_, int p_217657_4_) {
	       Tessellator tessellator = Tessellator.getInstance();
	       BufferBuilder bufferbuilder = tessellator.getBuffer();
	       GlStateManager.color4f(0.0F, 0.0F, 255.0F, 255.0F);
	       GlStateManager.disableTexture();
	       GlStateManager.enableColorLogicOp();
	       GlStateManager.logicOp(GlStateManager.LogicOp.OR_REVERSE);
	       bufferbuilder.begin(7, DefaultVertexFormats.POSITION);
	       bufferbuilder.pos((double)p_217657_1_, (double)p_217657_4_, 0.0D).endVertex();
	       bufferbuilder.pos((double)p_217657_3_, (double)p_217657_4_, 0.0D).endVertex();
	       bufferbuilder.pos((double)p_217657_3_, (double)p_217657_2_, 0.0D).endVertex();
	       bufferbuilder.pos((double)p_217657_1_, (double)p_217657_2_, 0.0D).endVertex();
	       tessellator.draw();
	       GlStateManager.disableColorLogicOp();
	       GlStateManager.enableTexture();
	    }

}
