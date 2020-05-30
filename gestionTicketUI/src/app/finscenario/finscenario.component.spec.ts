import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FinscenarioComponent } from './finscenario.component';

describe('FinscenarioComponent', () => {
  let component: FinscenarioComponent;
  let fixture: ComponentFixture<FinscenarioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FinscenarioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FinscenarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
