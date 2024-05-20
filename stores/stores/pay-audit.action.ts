import { Action } from '@ngrx/store';
import { PayAuditSearchFilterData } from '../../constants/pay-audit-constant';


export enum TypesActions {
    GET_PAY_AUDIT_DATA = '[GET_PAY_AUDIT_DATA] GET',
    GET_PAY_AUDIT_DATA_FILTERS = '[GET_PAY_AUDIT_DATA_FILTERS] GET',
    LOAD_PAY_AUDIT_DATA_FILTERS = '[LOAD_PAY_AUDIT_DATA_FILTERS] LOAD',
    LOAD_PAY_AUDIT_DATA = '[LOAD_PAY_AUDIT_DATA] LOAD',
    RESET_PAY_AUDIT_DATA = '[RESET_PAY_AUDIT_DATA] RESET',
}

export class getSelectedPilotAuditData implements Action {
  readonly type = TypesActions.GET_PAY_AUDIT_DATA;
  constructor(public filterData: any) { }
}

export class getSelectedPilotAuditDataWithFilters implements Action {
  readonly type = TypesActions.GET_PAY_AUDIT_DATA_FILTERS;
  constructor(public filterData: any) { }
}

export class loadSelectedPilotAuditDataWithFilters implements Action {
  readonly type = TypesActions.LOAD_PAY_AUDIT_DATA_FILTERS;
  constructor(public payload: any) { }
}


export class loadSelectedPilotAuditData implements Action {
  readonly type = TypesActions.LOAD_PAY_AUDIT_DATA;
  constructor(public payload: any) { }
}

export class resetAllAuditData implements Action {
  readonly type = TypesActions.RESET_PAY_AUDIT_DATA;
  constructor() { }
}


export type Actions = getSelectedPilotAuditData | getSelectedPilotAuditDataWithFilters| loadSelectedPilotAuditDataWithFilters | loadSelectedPilotAuditData | resetAllAuditData;
