package com.vera1s.pizzacafe.dto;
import com.vera1s.pizzacafe.entity.enums.IngredientsForPizza;
import com.vera1s.pizzacafe.entity.enums.NamePizza;
import com.vera1s.pizzacafe.entity.enums.SizeItem;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Set;
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class PizzaDTO {

    @NonNull
    private NamePizza namePizza;

    @NonNull
    private SizeItem sizeItem;

    @NonNull
    private Set<IngredientsForPizza> ingredients;

}
