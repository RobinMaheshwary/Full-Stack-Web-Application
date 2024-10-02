import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateByIdComponent } from './update-by-id.component';

describe('UpdateByIdComponent', () => {
  let component: UpdateByIdComponent;
  let fixture: ComponentFixture<UpdateByIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UpdateByIdComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UpdateByIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
