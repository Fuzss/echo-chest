package fuzs.echochest.neoforge.client;

import fuzs.echochest.common.EchoChest;
import fuzs.echochest.common.client.EchoChestClient;
import fuzs.echochest.common.data.client.ModLanguageProvider;
import fuzs.echochest.common.data.client.ModModelProvider;
import fuzs.puzzleslib.common.api.client.core.v1.ClientModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v2.core.DataProviderHelper;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@Mod(value = EchoChest.MOD_ID, dist = Dist.CLIENT)
public class EchoChestNeoForgeClient {

    public EchoChestNeoForgeClient() {
        ClientModConstructor.construct(EchoChest.MOD_ID, EchoChestClient::new);
        DataProviderHelper.registerDataProviders(EchoChest.MOD_ID, ModModelProvider::new, ModLanguageProvider::new);
    }
}
