package io.jmix.sampler.screen.ui.components.tagfield.simpletype;

import io.jmix.core.Messages;
import io.jmix.sampler.entity.CustomerGrade;
import io.jmix.ui.App;
import io.jmix.ui.screen.Install;
import io.jmix.ui.screen.ScreenFragment;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@UiController("tagfield-simpletype")
@UiDescriptor("tagfield-simpletype.xml")
public class TagFieldSimpleTypeSample extends ScreenFragment {

    @Autowired
    private Messages messages;

    private Locale locale = App.getInstance().getLocale();

    @Install(to = "tagField", subject = "searchExecutor")
    private List<CustomerGrade> tagFieldSearchExecutor(String searchString, Map<String, Object> searchParams) {
        return Stream.of(CustomerGrade.values())
                .filter(grade -> StringUtils.containsIgnoreCase(messages.getMessage(grade, locale), searchString))
                .collect(Collectors.toList());
    }
}
