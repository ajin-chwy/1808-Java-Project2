import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonalCookbookComponent } from './personal-cookbook.component';

describe('PersonalCookbookComponent', () => {
  let component: PersonalCookbookComponent;
  let fixture: ComponentFixture<PersonalCookbookComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PersonalCookbookComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonalCookbookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
