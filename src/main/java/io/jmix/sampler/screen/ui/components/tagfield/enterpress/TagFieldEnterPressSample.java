package io.jmix.sampler.screen.ui.components.tagfield.enterpress;

import io.jmix.core.Metadata;
import io.jmix.sampler.entity.Product;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.HasEnterPressHandler;
import io.jmix.ui.component.TagField;
import io.jmix.ui.screen.*;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("tagfield-enterpress")
@UiDescriptor("tagfield-enterpress.xml")
public class TagFieldEnterPressSample extends ScreenFragment {

    @Autowired
    private TagField<Product> tagFieldNewItem;

    @Autowired
    private Metadata metadata;
    @Autowired
    private Notifications notifications;

    @Subscribe
    public void onInit(InitEvent event) {
        tagFieldNewItem.setEnterPressHandler(new TagField.NewTagProvider<Product>() {
            @Nullable
            @Override
            public Product create(String text) {
                Product product = metadata.create(Product.class);
                product.setName(text);
                return product;
            }
        });
    }

    @Install(to = "tagFieldEnterHandler", subject = "enterPressHandler")
    private void tagFieldEnterHandlerEnterPressHandler(HasEnterPressHandler.EnterPressEvent enterPressEvent) {
        notifications.create(Notifications.NotificationType.TRAY)
                .withCaption("Entered text: " + enterPressEvent.getText())
                .show();
    }
}
