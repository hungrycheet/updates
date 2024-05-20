import { PayAuditService } from "../../services/pay-audit.service";
import { Injectable } from "@angular/core";
import { Actions, Effect, ofType } from "@ngrx/effects";
import { Store } from "@ngrx/store";
import { of } from "rxjs";
import { TypesActions, getSelectedPilotAuditData, getSelectedPilotAuditDataWithFilters, loadSelectedPilotAuditData, loadSelectedPilotAuditDataWithFilters} from "../actions/pay-audit.action";
import { OverlaySpinnerService } from "../../../shared/services/overlay-spinner.service";
import { catchError, map, switchMap } from "rxjs/operators";
import { OpenSnackBar } from "../../../core";



@Injectable()
export class PayAuditData {
  constructor(private actions$: Actions, private store: Store, private spinnerService: OverlaySpinnerService, private payAuditService:PayAuditService) { }

  @Effect() getAuditData$ = this.actions$.pipe(
    ofType(TypesActions.GET_PAY_AUDIT_DATA),
    switchMap((action: getSelectedPilotAuditData) => {
      return this.payAuditService.getPayAuditTableData(action.filterData).pipe(
        map((res: any) => {
          this.spinnerService.closeSpinner();
          return new loadSelectedPilotAuditData(res);
        }),
        catchError((res: any) => {
          this.store.dispatch(new OpenSnackBar('Loading Pay Audit Failed'));
          this.spinnerService.closeSpinner();
          return of(new loadSelectedPilotAuditData(null))
        })
      )
    }
    )
  );
  @Effect() getAuditDatawithFilters$ = this.actions$.pipe(
    ofType(TypesActions.GET_PAY_AUDIT_DATA_FILTERS),
    switchMap((action: getSelectedPilotAuditDataWithFilters) => {
      return this.payAuditService.getPayAuditTableData(action.filterData).pipe(
        map((res: any) => {
          this.spinnerService.closeSpinner();
          return new loadSelectedPilotAuditDataWithFilters(res);
        }),
        catchError((res: any) => {
          this.store.dispatch(new OpenSnackBar('Loading Pay Audit Failed'));
          this.spinnerService.closeSpinner();
          return of(new loadSelectedPilotAuditDataWithFilters(null))
        })
      )
    }
    )
  );
}
