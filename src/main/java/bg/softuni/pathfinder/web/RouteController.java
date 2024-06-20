package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.service.DTO.RouteShortInfoDTO;
import bg.softuni.pathfinder.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {

    private RouteService routeService;

    //@Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes")
    public String routes(Model model) {

        RouteShortInfoDTO routeShortInfoDTO = routeService.getRandomRoute();
        model.addAttribute("route", routeShortInfoDTO);
        return "routes";
    }
}
