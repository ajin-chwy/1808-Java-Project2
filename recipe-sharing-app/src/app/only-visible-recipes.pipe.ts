import { Pipe, PipeTransform } from '@angular/core';
import { Recipe } from './types/recipe';
@Pipe({
  name: 'onlyVisibleRecipes'
})
export class OnlyVisibleRecipesPipe implements PipeTransform {

  transform(value: Array<Recipe>, cond: boolean): Array<Recipe> {
    if (!value) {
      return [];
    }
    return value.filter(it => it.deleted === !cond);
  }

}
