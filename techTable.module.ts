import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TechTableComponent } from './techTable.component'; 
import { Routes, RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule,ReactiveFormsModule  } from '@angular/forms';

const routes: Routes = [
  {
    path: '',
    data: {
      title: 'techTable',
      urls: [
        { title: '', url: '/techTable' },
        { title: 'techTable' }
      ]
    },
    component: TechTableComponent
  }
];

@NgModule({
  imports: [
    FormsModule,
    CommonModule,
    NgbModule,
    ReactiveFormsModule,
    RouterModule.forChild(routes)
  ],
  declarations: [TechTableComponent]
})
export class TechTableModule { }