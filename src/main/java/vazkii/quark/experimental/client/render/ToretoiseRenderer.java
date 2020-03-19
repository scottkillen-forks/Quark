package vazkii.quark.experimental.client.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import vazkii.quark.base.Quark;
import vazkii.quark.experimental.client.layer.ToretoiseOreLayer;
import vazkii.quark.experimental.client.model.ToretoiseModel;
import vazkii.quark.experimental.entity.ToretoiseEntity;

public class ToretoiseRenderer extends MobRenderer<ToretoiseEntity, ToretoiseModel>{

	private static final ResourceLocation BASE_TEXTURE = new ResourceLocation(Quark.MOD_ID, "textures/model/entity/toretoise/base.png");
	
	public ToretoiseRenderer(EntityRendererManager m) {
		super(m, new ToretoiseModel(), 1F);
		addLayer(new ToretoiseOreLayer(this));
	}

	@Override
	public ResourceLocation getEntityTexture(ToretoiseEntity entity) {
		return BASE_TEXTURE;
	}

}