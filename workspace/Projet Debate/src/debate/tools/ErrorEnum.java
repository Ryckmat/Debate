/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package debate.tools;

/**
 *
 * @author David
 */
public enum ErrorEnum {
    SelfRedundancyArgument,
    GlobalRedundancyArgument,
    SelfRedundancyFormula,
    GlobalRedundancyFormula,
    NoneArgumentSelected,
    NoneFormulaSelected,
    Loading,
    LoadingParameters,
    LoadingFormulas,
    LoadingRequest,
    LoadingArguments, 
    SelfConsistencyFormula,
    GlobalConsistencyFormula,
    SelfConsistencyArgument,
    GlobalConsistencyArgument,
    MistakenFormula ,   
    ForgottenConclusion,
    Solver, 
    MissingPlayer1, 
    MissingPlayer2,
    EmptyNameField, 
    EmptySupport, 
    ConclusionNotModified, Saving, 
    
}
