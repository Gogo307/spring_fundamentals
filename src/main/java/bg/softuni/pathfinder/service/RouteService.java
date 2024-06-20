package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.data.RouteRepository;
import bg.softuni.pathfinder.model.Picture;
import bg.softuni.pathfinder.model.Route;
import bg.softuni.pathfinder.service.DTO.RouteShortInfoDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class RouteService {

    private RouteRepository routeRepository;
    private Random random;

    private ModelMapper modelMapper;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
        this.modelMapper = new ModelMapper();
        this. random = new Random();
    }

    @Transactional// to counter the exc
    public RouteShortInfoDTO getRandomRoute(){
        long routesCount = routeRepository.count(); // starts form 0 to n - 1
        long randomId = random.nextLong(routesCount) + 1;// that is why we add a 1

        Optional<Route> route = routeRepository.findById(randomId); // TODO ???????????????????????????????????????

        if(route.isEmpty()){
            //throw exc
        }

        RouteShortInfoDTO dto = modelMapper.map(route.get(), RouteShortInfoDTO.class);
        Optional<Picture> firstImage = route.get().getPictures().stream().findFirst();

        dto.setImageUrl(firstImage.get().getUrl());
        return dto;
    }
}
