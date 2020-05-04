import { Component, OnInit } from '@angular/core';
import { User } from '../core/models/user';
import { AuthService } from '../core/services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  public user: User = new User();

  constructor(
    private auth: AuthService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.user.username = '';
    this.user.password = '';

    if (this.auth.isAuthenticated()) {
      this.router.navigate(['/layout']);
    } 
  }
  keyDownFunction(event) {
    if(event.keyCode == 13) {
      this.login();
      // rest of your code
    }
  }

  unauthorized;
  login() {
    this.auth.login(this.user).subscribe((res:any) =>   {
      console.log('resultado', res);
      
      this.auth.setCurrentToken(res); 
      localStorage.setItem("token", res);

      this.router.navigate(['layout']);
    }, 
    error => {
      this.unauthorized = "Username ou password incorrecta!";
    });
  }

}
