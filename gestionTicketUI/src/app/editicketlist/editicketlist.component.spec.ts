import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditicketlistComponent } from './editicketlist.component';

describe('EditicketlistComponent', () => {
  let component: EditicketlistComponent;
  let fixture: ComponentFixture<EditicketlistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditicketlistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditicketlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
