import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetCarIdComponent } from './get-car-id.component';

describe('GetCarIdComponent', () => {
  let component: GetCarIdComponent;
  let fixture: ComponentFixture<GetCarIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [GetCarIdComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GetCarIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
