package io.jmix.sampler.screen.ui.components.tagfield.dataaware;

import io.jmix.core.Metadata;
import io.jmix.sampler.entity.Order;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.ScreenFragment;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("tagfield-dataaware")
@UiDescriptor("tagfield-dataaware.xml")
public class TagFieldDataawareSample extends ScreenFragment {

    @Autowired
    private InstanceContainer<Order> orderDc;
    @Autowired
    private Metadata metadata;

    @Subscribe
    public void onInit(InitEvent event) {
        // InstanceContainer initialization. It is usually done automatically if the screen is
        // inherited from StandardEditor and is used as an entity editor.
        Order order = metadata.create(Order.class);
        orderDc.setItem(order);
    }
}
