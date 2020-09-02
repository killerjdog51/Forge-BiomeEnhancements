package io.github.killerjdog51.biome_enhancments.entity.boat;

import com.mojang.blaze3d.platform.GlStateManager;

import io.github.killerjdog51.biome_enhancments.BiomeEnhancements;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.BoatModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModBoatRenderer extends EntityRenderer<ModBoatEntity> {
   private static final ResourceLocation[] BOAT_TEXTURES = new ResourceLocation[]{new ResourceLocation("textures/entity/boat/oak.png"), new ResourceLocation(BiomeEnhancements.MOD_ID + ":textures/entity/boat/baobab.png"), new ResourceLocation(BiomeEnhancements.MOD_ID + ":textures/entity/boat/mangrove.png"), new ResourceLocation(BiomeEnhancements.MOD_ID + ":textures/entity/boat/palm.png")};
   protected final BoatModel field_76998_a = new BoatModel();

   public ModBoatRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn);
      this.shadowSize = 0.8F;
   }

   public void doRender(ModBoatEntity entity, double x, double y, double z, float entityYaw, float partialTicks) {
      GlStateManager.pushMatrix();
      this.setupTranslation(x, y, z);
      this.setupRotation(entity, entityYaw, partialTicks);
      this.bindEntityTexture(entity);
      if (this.renderOutlines) {
         GlStateManager.enableColorMaterial();
         GlStateManager.setupSolidRenderingTextureCombine(this.getTeamColor(entity));
      }

      this.field_76998_a.render(entity, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
      if (this.renderOutlines) {
         GlStateManager.tearDownSolidRenderingTextureCombine();
         GlStateManager.disableColorMaterial();
      }

      GlStateManager.popMatrix();
      super.doRender(entity, x, y, z, entityYaw, partialTicks);
   }

   public void setupRotation(ModBoatEntity entityIn, float entityYaw, float partialTicks) {
      GlStateManager.rotatef(180.0F - entityYaw, 0.0F, 1.0F, 0.0F);
      float f = (float)entityIn.getTimeSinceHit() - partialTicks;
      float f1 = entityIn.getDamageTaken() - partialTicks;
      if (f1 < 0.0F) {
         f1 = 0.0F;
      }

      if (f > 0.0F) {
         GlStateManager.rotatef(MathHelper.sin(f) * f * f1 / 10.0F * (float)entityIn.getForwardDirection(), 1.0F, 0.0F, 0.0F);
      }

      float f2 = entityIn.getRockingAngle(partialTicks);
      if (!MathHelper.epsilonEquals(f2, 0.0F)) {
         GlStateManager.rotatef(entityIn.getRockingAngle(partialTicks), 1.0F, 0.0F, 1.0F);
      }

      GlStateManager.scalef(-1.0F, -1.0F, 1.0F);
   }

   public void setupTranslation(double x, double y, double z) {
      GlStateManager.translatef((float)x, (float)y + 0.375F, (float)z);
   }

   protected ResourceLocation getEntityTexture(ModBoatEntity entity) {
      return BOAT_TEXTURES[entity.getModBoatType().ordinal()];
   }

   public boolean isMultipass() {
      return true;
   }

   public void renderMultipass(ModBoatEntity entityIn, double x, double y, double z, float entityYaw, float partialTicks) {
      GlStateManager.pushMatrix();
      this.setupTranslation(x, y, z);
      this.setupRotation(entityIn, entityYaw, partialTicks);
      this.bindEntityTexture(entityIn);
      this.field_76998_a.renderMultipass(entityIn, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
      GlStateManager.popMatrix();
   }
}