package io.jmix.sampler.screen.ui.components.tagfield.tagclick;

import io.jmix.sampler.entity.Product;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.TagField;
import io.jmix.ui.screen.ScreenFragment;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("tagfield-tagclick")
@UiDescriptor("tagfield-tagclick.xml")
public class TagFieldTagClickSample extends ScreenFragment {

    @Autowired
    private Notifications notifications;

    @Subscribe("tagField")
    public void onTagFieldTagClick(TagField.TagClickEvent<Product> event) {
        notifications.create(Notifications.NotificationType.TRAY)
                .withCaption(event.getItem().getName())
                .show();
    }
}
