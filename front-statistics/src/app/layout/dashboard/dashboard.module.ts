import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardRoutingModule } from './dashboard-routing.module';
import { DashboardComponent } from './dashboard.component';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { Grafico1Component } from './micael/grafico1/grafico1.component';
import { Grafico2Component } from './filipe/grafico2/grafico2.component';
import { Grafico3Component } from './ana/grafico3/grafico3.component';
import { Grafico4Component } from './vasco/grafico4/grafico4.component';
import {MatSelectModule} from '@angular/material/select';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { ConversaoSemanalComponent } from './conversao-semanal/conversao-semanal.component';
import { TableClientComponent } from './table-client/table-client.component';

@NgModule({
  declarations: [DashboardComponent, Grafico1Component, Grafico2Component, Grafico3Component, Grafico4Component, ConversaoSemanalComponent, TableClientComponent],
  imports: [
    CommonModule,
    MatGridListModule,
    MatCardModule,
    MatMenuModule,
    MatIconModule,
    MatButtonModule,
    MatSelectModule,
    DashboardRoutingModule,
    BsDatepickerModule
  ]
})

export class DashboardModule { }
