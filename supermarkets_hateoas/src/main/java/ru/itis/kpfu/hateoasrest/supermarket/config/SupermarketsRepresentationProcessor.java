package ru.itis.kpfu.hateoasrest.supermarket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;
import ru.itis.kpfu.hateoasrest.supermarket.controllers.SupermarketsController;
import ru.itis.kpfu.hateoasrest.supermarket.models.Supermarket;

@Component
public class SupermarketsRepresentationProcessor implements RepresentationModelProcessor<EntityModel<Supermarket>> {
    @Autowired
    private RepositoryEntityLinks links;

    public SupermarketsRepresentationProcessor() {
    }

    public EntityModel<Supermarket> process(EntityModel<Supermarket> model) {
        Supermarket supermarket = (Supermarket)model.getContent();
        if (supermarket.getState().equals("Draft")) {
            model.add(WebMvcLinkBuilder.linkTo(((SupermarketsController)WebMvcLinkBuilder.methodOn(SupermarketsController.class, new Object[0])).publish(supermarket.getId())).withRel("open"));
        }

        if (supermarket.getState().equals("Open")) {
            model.add(this.links.linkToItemResource(Supermarket.class, supermarket.getId()).withRel("closed"));
        }

        return model;
    }
}

