import { OnlyVisibleRecipesPipe } from './only-visible-recipes.pipe';

describe('OnlyVisibleRecipesPipe', () => {
  it('create an instance', () => {
    const pipe = new OnlyVisibleRecipesPipe();
    expect(pipe).toBeTruthy();
  });
});
