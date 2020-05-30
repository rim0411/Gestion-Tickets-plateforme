import { TestBed } from '@angular/core/testing';

import { AuthServiceSService } from './auth-service-s.service';

describe('AuthServiceSService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AuthServiceSService = TestBed.get(AuthServiceSService);
    expect(service).toBeTruthy();
  });
});
